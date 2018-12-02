var cart = {}; //моя корзина


// $.ajax({
//     url:"http://localhost:8080/person",
//     type:"GET",
//     contentType:"application/json",
//
//     success:function(data){
//         var out = '';
//         for (var key in data){
//             out+='<div class="single-goods">';
//             out+='<h3>'+data[key]['name']+'</h3>';
//             out+='<p>Цена: '+data[key]['cost']+'</p>';
//             out+='<img src="'+data[key].image+'">';
//             out+='<button class="add-to-cart" data-art="'+key+'">Купить</button>';
//             out+='</div>';
//         }
//         $('#goods').html(out);
//         $('button.add-to-cart').on('click', addToCart);
//         localStorage.setItem('produkt', data);
//         alert(localStorage.getItem("produkt"));
//
//
//         $('#goods').html(out);
//         $('button.add-to-cart').on('click', addToCart);
//
//     },
// });


$('document').ready(function(){
    loadGoods();
});





function loadGoods() {
    $.ajax({
        url:"http://localhost:8080/category",
        type:"GET",
        headers: {
            "Authorize":"Bearer " + localStorage.getItem("token")
        },
        contentType:"application/json",
        success:function(data){
            for(var i=0; i<data.length;i++){
                var r="<li class=\"p-t-4\">\n" +
                    "\t\t\t\t\t\t\t\t<a href=\"#\" class=\"s-text13\">\n" +
                    "\t\t\t\t\t\t\t\t\t" +
                    data[i].nameCategory +
                    "\t\t\t\t\t\t\t\t</a>\n" +
                    "\t\t\t\t\t\t\t</li>"
                $("#categoryList").append(r);
            }
        },
        error:function(error){
            console.log(error);
        }
    });

    $.ajax({
        url:"http://localhost:8080/goodsInOrder/name?orderId=1",
        type:"GET",
        headers: {
            "Authorize":"Bearer " + localStorage.getItem("token"),
        },
        contentType: "application/json",
        success: function (data) {
            var out = '';
            var test= 1;

            for (var key in data) {
                // out += '<div class="single-goods">';
                // out += '<h3>' + data[key].goodsResponse.nameGoods + '</h3>';
                // out += '<input type="number" name="number" min="1" max="5">';
                // out += '<p>Цена: ' + data[key].goodsResponse.price + '</p>';
                // out += '<img src="images/cherry.png">';
                // out += '<button class="add-to-cart" data-id="' + data[key]['id'] + '">Купити</button>';
                // out += '</div>';
                // test= data[key]['nameGoods'];


                out += '<tr class="table-row">';
                out += '<td class="column-1">';
                out += '<div class="cart-img-product b-rad-4 o-f-hidden">';
                out += '<img src="' + data[key].goodsResponse.img + '" alt="IMG-PRODUCT">';
                out += '</div>';
                out += '</td>';
                out += '<td class="column-2">'+ data[key].goodsResponse.nameGoods +'</td>';
                out += '<td class="column-3">$ ' + data[key].goodsResponse.price + '</td>';
                out += '<td class="column-4">';
                out += '<div class="flex-w bo5 of-hidden w-size17">';
                out += '<button class="btn-num-product-down color1 flex-c-m size7 bg8 eff2">';
                out += '<i class="fs-12 fa fa-minus" aria-hidden="true"></i>';
                out += '</button>';
                out += '<input class="size8 m-text18 t-center num-product" type="number"';
                out += 'name="num-product1" value="1">';
                out += '<button class="btn-num-product-up color1 flex-c-m size7 bg8 eff2">';
                out += '<i class="fs-12 fa fa-plus" aria-hidden="true"></i>';
                out += '</button>';
                out += '</div>';
                out += '</td>';
                out += '<td class="column-5">$36.00</td>';
                out += '</tr>';

            }
            $('#goods').html(out);
            $('button.add-to-cart').on('click', addToCart);
        },
        error: function (error) {
            console.log(error);
        }
    });
}


    function addToCart() {
        var id = $(this).attr('data-id');
        var order = {
            idGoods:id,
            idOrder:1
        };

    $.ajax({
        url:"http://localhost:8080/goodsInOrder",
        type:"POST",
        headers: {
            "Authorize":"Bearer " + localStorage.getItem("token")
        },
        contentType:"application/json",
        data:JSON.stringify(order),
        success:function(data){

        },
        error:function(error){
            console.log(error);
        }
    });





    //добавляем товар в корзину
    var articul = $(this).attr('data-art');
    if (cart[articul]!=undefined) {
        cart[articul]++;
    }
    else {
        cart[articul] = 1;
    }

    console.log(cart);


}