function deleteCart(cartId) {
    $.ajax({
        contentType:"application/json; charset=utf-8",
        url: "/cart/delete",
        data: JSON.stringify({ cartId: cartId }),
        type:"POST"
    }).done(function () {
        $("#"+cartId).remove();
    });
}