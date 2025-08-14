const userIdInput = document.getElementById('userId');
const passwordInput = document.getElementById('password');
const statusText = document.getElementById('status');

if (localStorage.getItem('userId')) {
    statusText.textContent = `Logged in as: ${localStorage.getItem('userId')}`;
}

document.getElementById('loginBtn').addEventListener('click', () => {
    const userId = userIdInput.value.trim();
    const password = passwordInput.value.trim();

    if (!userId || !password) {
        statusText.textContent = 'Please enter both User ID and Password.';
        return;
    }

    localStorage.setItem('userId', userId);
    statusText.textContent = `Logged in as: ${userId}`;
});

document.getElementById('logoutBtn').addEventListener('click', () => {
    localStorage.removeItem('userId');
    statusText.textContent = 'Logged out.';
});
