'use strict';

jQuery(function($){

    $('.btn-add-to-cart').click(function(event){
        addToCart($(this).parents('.form-add-to-cart'));
    });

    $('.btn-remove-from-cart').click(function(event){
        removeFromCart($(this).parents('.form-remove-from-cart'));
    });

});

function addToCart(form){
    var formData = form.serializeArray();
    $.ajax({
        type : "POST",
        cache : false,
        url : '/cart/add',
        data : formData,
        dataType: "json",

        }).done(function(result){
            if(0===result){
                alert('カートに追加しました');
            }else if(1===result){
                alert('この商品はすでにカートに追加されています');
            }


    }).fail(function(jqXHR, textStatus, errorThrown){
        alert('カートへの追加に失敗しました');

    }).always(function(){

    });
}

function removeFromCart(form){
    var formData = form.serializeArray();
    $.ajax({
        type : "DELETE",
        cache : false,
        url : '/cart/remove',
        data : formData,
        dataType: "json",

        }).done(function(result){
           alert('カートから削除しました');
           window.location.href = '/cart/view';

    }).fail(function(jqXHR, textStatus, errorThrown){
        alert('カートからの削除に失敗しました');

    }).always(function(){

    });

}