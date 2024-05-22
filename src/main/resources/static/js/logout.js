document.addEventListener("DOMContentLoaded", function() {
    if (location.href.indexOf("logout") > 1) {
        const p = document.createElement('p');
        p.innerHTML = "ログアウトしました"
        loginTitle = document.querySelector('#login-title');
        loginTitle.after(p)       }
});
