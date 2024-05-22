var registerButton = document.getElementById('btn-register-goods');

registerButton.addEventListener('click', function() {
    var element = document.getElementById('register-goods-area');
    // elementのcssにdisplay: none;が設定されている場合display: block;に変更する
    element.style.display = 'block';


});

var registerSubmitButton = document.getElementById('btn-register-goods-submit');

registerSubmitButton.addEventListener('click', function() {
    var element = document.getElementById('register-goods-area');
    element.style.display = 'none';

});

var registerCancelButton = document.getElementById('btn-register-goods-cancel');

registerCancelButton.addEventListener('click', function() {
    var element = document.getElementById('register-goods-area');
    element.style.display = 'none';

});