'use strict';

jQuery(function($){

    $('#btn-set-value-to-session').click(function(event){
        alert('test');
        showHiddenValue();
    });
});

function showHiddenValue(){
    var buttonValue = JSON.stringify({
        value : $('#btn-set-value-to-session').val()
    });
    console.log(buttonValue);

    $.ajax({
        type : "PUT",
        cache : false,
        url : '/study/setValueToSession',
        data : buttonValue,
        dataType : 'json',
    }).done(function(data){
        alert('セッションを更新しました');
        window.location.href = '/study/restButtonListResponse';
    }).fail(function(jqXHR, textStatus, errorThrown){
        alert('セッションの更新に失敗しました');
    }).always(function(){

    });
}