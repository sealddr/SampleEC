'use strict';

jQuery(function($){

    $('.btn-set-value-to-session').click(function(event){
        showHiddenValue($(this).val());
    });
});

function showHiddenValue(thisValue){
    var buttonValue = JSON.stringify({
        value : thisValue
    });

    $.ajax({
        type : "POST",
        cache : false,
        url : '/study/setValueToSession',
        data : buttonValue,
        dataType: "json",
        contentType: 'application/json',

        }).done(function(data){
        alert('セッションを更新しました');
        window.location.href = '/study/buttonListResponse';

    }).fail(function(jqXHR, textStatus, errorThrown){
        alert('セッションの更新に失敗しました');

    }).always(function(){

    });
}