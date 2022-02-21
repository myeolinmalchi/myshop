function updateQuantity(cartId) {
    const c = $("#"+cartId);
    const quantity = c.find("#quantity").val();
    const price = c.find("#price").text();
    const totPrice = price * quantity;

    $.ajax({
        contentType:"application/json; charset=utf-8",
        url: "/cart/update/quantity",
        data: JSON.stringify({
            cartId: cartId,
            quantity: quantity
        }),
        type:"POST"
    }).done(function () {
        c.find("#totPrice").text(totPrice)
    });
}