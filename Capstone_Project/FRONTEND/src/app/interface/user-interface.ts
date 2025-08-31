export interface UserInterface {
     id?: number;
  firstname: string;
  lastName: string;
  email: string;
  passWord: string;
  address?: string;
  userType?: number; // 0 = admin, 1 = user
}