var registerButton = document.getElementById('btn-register-goods');

registerButton.addEventListener('click', function() {
    var element = document.getElementById('register-goods-area');
    element.style.display = 'block';

    // bodyのスクロールを無効にする
    document.body.style.overflow = 'hidden';
});

var registerSubmitButton = document.getElementById('btn-register-goods-submit');

registerSubmitButton.addEventListener('click', function() {
    var element = document.getElementById('register-goods-area');
    element.style.display = 'none';

    // bodyのスクロールを有効にする
    document.body.style.overflow = 'auto';

});

var registerCancelButton = document.getElementById('btn-register-goods-cancel');

registerCancelButton.addEventListener('click', function() {
    var element = document.getElementById('register-goods-area');
    element.style.display = 'none';

    // bodyのスクロールを有効にする
    document.body.style.overflow = 'auto';

});

var updateButtons = document.querySelectorAll('.btn-update-goods');

updateButtons.forEach(function(button) {
    button.addEventListener('click', function() {
        fetch('/api/goods/' + goodsId)
            .then(response => response.json())
            .then(data => {
                var updateForm = document.querySelector('.update-goods-form');
                updateForm.querySelector('.input-update-goodsname').value = data.goodsName;
                updateForm.querySelector('.textarea-update-goodsdescription').value = data.goodsDescription;
        });

        var element = document.getElementById('update-goods-area');
        element.style.display = 'block';
        
        // bodyのスクロールを無効にする
        document.body.style.overflow = 'hidden';
    
    });
});

var updateSubmitButton = document.getElementById('btn-update-goods-submit');

updateSubmitButton.addEventListener('click', function() {
    var element = document.getElementById('update-goods-area');
    element.style.display = 'none';

    // bodyのスクロールを有効にする
    document.body.style.overflow = 'auto';

});

var updateCancelButton = document.getElementById('btn-update-goods-cancel');

updateCancelButton.addEventListener('click', function() {
    var element = document.getElementById('update-goods-area');
    element.style.display = 'none';

    // bodyのスクロールを有効にする
    document.body.style.overflow = 'auto';

});
