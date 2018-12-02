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
        url:"http://localhost:8080/goods",
        type:"GET",
        headers: {
            "Authorize":"Bearer " + localStorage.getItem("token"),
        },
        contentType: "application/json",
        success: function (data) {

            var out = '';
            for (var key in data) {
                out += '<div class="single-goods">';
                out += '<h3>' + data[key]['id'] + '</h3>';
                out += '<p>Цена: ' + data[key]['cost'] + '</p>';
                out += '<img src="cherry.png">';
                out += '<button class="add-to-cart" data-art="' + key + '">Купить</button>';
                out += '</div>';
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
    var category = {
        idGoods: 1,
        idOrder:1
        // nameCategory:$("#nameCategory").val()
    };

    $.ajax({
        url:"http://localhost:8080/goodsInOrder",
        type:"POST",
        headers: {
            "Authorize":"Bearer " + localStorage.getItem("token")
        },
        contentType:"application/json",
        data:JSON.stringify(category),
        success:function(data){
            $("#categoryInShop").append("<li>"+data.nameCategory+"</li>");
            alert("Good");


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