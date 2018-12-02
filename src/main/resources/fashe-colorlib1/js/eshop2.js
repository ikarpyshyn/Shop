var cart = {}; //моя корзина
var x = "2";

// $('document').ready(function () {
//     loadGoods();
// });
$('document').ready(function () {
    loadCategory();
});


// function loadGoods() {
    //Виводим категорії

    $.ajax({
        url: "http://localhost:8080/goodsInOrder",
        type: "GET",
        headers: {
            "Authorize": "Bearer " + localStorage.getItem("token"),
        },
        contentType: "application/json",
        success: function (data) {
            var out = '<table border="2"><tr><td >Замовлення</td><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Назва&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td><td>&nbsp;&nbsp;&nbsp;Ціна&nbsp;&nbsp;&nbsp;</td></tr></table>';
            var test = 1;

            for (var key in data) {
                out += '<br>';
                out += '<table border="2">';
                out += '<tr>';
                out += '<td> ' +"--------"+ data[key].orderResponse.id +'--------' + ' </td>';
                out += '<td> --' + data[key].goodsResponse.nameGoods + '-- </td>';
                out += '<td>-- ' + data[key].goodsResponse.price + '-- </td>';
                out += '</tr>';
                out += '</table>';
                // out += '<br>';
            }
            $('#goods').html(out);
            $('button.add-to-cart').on('click', addToCart);
        },
        error: function (error) {
            console.log(error);
        }
    });


// }
function loadCategory() {
    $.ajax({
        url: "http://localhost:8080/order",
        type: "GET",
        headers: {
            "Authorize": "Bearer " + localStorage.getItem("token")
        },
        contentType: "application/json",
        success: function (data) {
            var out = '';
            for (var key in data) {
                out += '<li class="p-t-4">';
                out += '<button class="findByCategory" data-id="' + data[key].id + '"> замовлення------------------' + data[key].id+'  Власник:  ' +data[key].userResponse.email + '</button>';
                out += '</a>';
                out += '</li>';
                out += '<br>';

            }
            $('#categoryList').html(out);
            $('button.findByCategory').on('click', findByCategory);
        },
        error: function (error) {
            console.log(error);
        }
    });
}
function addToCart() {
    var id = $(this).attr('data-id');
    var order = {
        idGoods: id,
        idOrder: 1
    };
    //Добавляєм товар в корзину
    $.ajax({
        url: "http://localhost:8080/goodsInOrder",
        type: "POST",
        headers: {
            "Authorize": "Bearer " + localStorage.getItem("token")
        },
        contentType: "application/json",
        data: JSON.stringify(order),
        success: function (data) {
            alert("товар додано id "+id);
        },
        error: function (error) {
            console.log(error);
        }
    });
}

function findByCategory() {
    var id = $(this).attr('data-id');
    // x = '/name?orderId=' + id;
    // var x = "";
    $.ajax({
        url: "http://localhost:8080/goods/name?subCategoryId=" + id,
        type: "GET",
        headers: {
            "Authorize": "Bearer " + localStorage.getItem("token"),
        },
        contentType: "application/json",
        success: function (data) {
            var out = '';
            var test = 1;

            for (var key in data) {
                out += '<div class="single-goods">';
                out += '<h3>' + data[key]['nameGoods'] + '</h3>';
                out += '<p>Цена: ' + data[key]['price'] + '</p>';
                out += '<img src="' + data[key]['img'] + '">';
                out += '<button class="add-to-cart" data-id="' + data[key]['id'] + '">Купити</button>';
                out += '</div>';
            }
            $('#goods').html(out);
            $('button.add-to-cart').on('click', addToCart);
        },
        error: function (error) {
            console.log(error);
        }
    });
};

