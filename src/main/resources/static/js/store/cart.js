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
    var token = $("meta[name='_csrf']").attr("content");
    var header = $("meta[name='_csrf_header']").attr("content");
    $(document).ajaxSend(function(e, xhr, options) {
      xhr.setRequestHeader(header, token);
    });

    var formData = form.serializeArray();
    $.ajax({
        type : "POST",
        cache : false,
        url : '/store/cart/add',
        data : formData,
        dataType: "json",
        headers: {
            'X-CSRF-TOKEN': $('meta[name="_csrf_header"]').attr('content'),
           }
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
    var token = $("meta[name='_csrf']").attr("content");
    var header = $("meta[name='_csrf_header']").attr("content");
    $(document).ajaxSend(function(e, xhr, options) {
      xhr.setRequestHeader(header, token);
    });

    var formData = form.serializeArray();
    $.ajax({
        type : "DELETE",
        cache : false,
        url : '/store/cart/remove',
        data : formData,
        dataType: "json",

        }).done(function(result){
           alert('カートから削除しました');
           window.location.href = '/store/cart/view';

    }).fail(function(jqXHR, textStatus, errorThrown){
        alert('カートからの削除に失敗しました');

    }).always(function(){

    });

}