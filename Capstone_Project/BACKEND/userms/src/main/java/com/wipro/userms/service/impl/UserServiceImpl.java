package com.wipro.userms.service.impl;

import com.wipro.userms.service.UserService;
import com.wipro.userms.util.AppConstant;
import com.wipro.userms.util.EncryptUtil;
import com.wipro.userms.dto.Token;
import com.wipro.userms.entity.User;
import com.wipro.userms.repo.UserRepo;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.security.Key;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public List<User> findAll() {
        return userRepo.findAll();
    }

    @Override
    public User findById(int id) {
        Optional<User> opt = userRepo.findById(id);
        return opt.orElse(null);
    }


    public String registerUser(User user) {
        if (userRepo.findByEmail(user.getEmail()) != null) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "EMAIL ID ALREADY EXISTS");
        }
        user.setUserType(1);
        save(user);
        return "USER REGISTERED SUCCESSFULLY";
    }


    public String registerAdmin(User user) {
        if (userRepo.findByEmail(user.getEmail()) != null) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "EMAIL ID ALREADY EXISTS");
        }
        user.setUserType(0); 
        save(user);
        return "ADMIN REGISTERED SUCCESSFULLY";
    }

    @Override
    public void save(User user) {

        if (user.getSalt() == null || user.getSalt().isEmpty()) {
            String salt = org.springframework.security.crypto.bcrypt.BCrypt.gensalt();
            user.setSalt(salt);
        }


        user.setPassWord(EncryptUtil.getEncryptedPassword(user.getPassWord(), user.getSalt()));

        // using email as userId
        user.setUserId(user.getEmail());

        userRepo.save(user);
    }

    @Override
    public void deleteById(int id) {
        userRepo.deleteById(id);
    }

    @Override
    public Token login(User user) {
        User dbUser = userRepo.findByEmail(user.getEmail());
        if (dbUser == null) {

            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid credentials");
        }

        String encrypted = EncryptUtil.getEncryptedPassword(user.getPassWord(), dbUser.getSalt());
        if (!encrypted.equals(dbUser.getPassWord())) {

            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid credentials");
        }

        dbUser.setLoggedIn(true);
        userRepo.save(dbUser);

        String jwt = generateJWT(dbUser.getId(), dbUser.getUserType());

        Token token = new Token();
        token.setToken(jwt);
        return token;
    }

    public boolean logout(int userId) {
        Optional<User> userOpt = userRepo.findById(userId);
        if (userOpt.isPresent()) {
            User u = userOpt.get();
            u.setLoggedIn(false);
            userRepo.save(u);
            return true;
        }
        return false;
    }

    private String generateJWT(int userId, int userType) {
        Key key = Keys.hmacShaKeyFor(Base64.getDecoder().decode(AppConstant.SECRET));

        String role = (userType == 0) ? "ROLE_ADMIN" : "ROLE_USER";
        List<GrantedAuthority> authorities =
                AuthorityUtils.commaSeparatedStringToAuthorityList(role);

        return Jwts.builder()
                .setId("jwtExample")
                .setSubject(String.valueOf(userId))
                .claim("authorities", authorities.stream()
                        .map(GrantedAuthority::getAuthority)
                        .collect(Collectors.toList()))
                .setIssuedAt(new Date())
                // 30 minutes (1800000 ms)
                .setExpiration(new Date(System.currentTimeMillis() + 1800000L))
                .signWith(key, SignatureAlgorithm.HS512)
                .compact();
    }
}
