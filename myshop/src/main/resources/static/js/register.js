function validation(type){
    const element = $("#"+type);
    const value= element.val();

    console.log(value);

    $.ajax({
        contentType:"application/json; charset=utf-8",
        url: "/register/valid/"+type,
        data: JSON.stringify({
            type: type,
            value: value
        }),
        type: "POST"
    }).done(function (json){
        if(json.msg == null){
            element.removeClass("is-invalid");
            element.addClass("is-valid");
        }else{
            element.removeClass("is-valid");
            element.addClass("is-invalid");
            element.siblings(".validation").text(json.msg);
        }
    });
}