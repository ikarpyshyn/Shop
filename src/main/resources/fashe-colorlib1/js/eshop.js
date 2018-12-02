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
        url: "http://localhost:8080/goods",
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
                out += '<img src="images/cherry.png">';
                out += '<button class="add-to-cart" data-id="' + data[key]['id'] + '">Купити</button>';
                out += '</div>';






                // out += '<div class="col-sm-12 col-md-6 col-lg-4 p-b-50">';
                // <!-- Block2 -->
                // out += '<div class="block2">';
                // out += '<div class="block2-img wrap-pic-w of-hidden pos-relative">';
                // out += '<img src="images/item-03.jpg" alt="IMG-PRODUCT">';
                //
                // out += '<div class="block2-overlay trans-0-4">';
                // out += '<a href="#" class="block2-btn-addwishlist hov-pointer trans-0-4">';
                // out += '<i class="icon-wishlist icon_heart_alt" aria-hidden="true"></i>';
                // out += '<i class="icon-wishlist icon_heart dis-none" aria-hidden="true"></i>';
                // out += '</a>';
                //
                // out += '<div class="block2-btn-addcart w-size1 trans-0-4">';
                // <!-- Button -->
                // out += '<button class="add-to-cart" data-id="' + data[key]['id'] + '">К';
                // out += 'Add to Cart';
                // out += '</button>';
                // out += '</div>';
                // out += '</div>';
                // out += '</div>';
                //
                // out += '<div class="block2-txt p-t-20">';
                // out += '<a href="product-detail.html" class="block2-name dis-block s-text3 p-b-5">';
                // out += 'Denim jacket blue';
                // out += '</a>';
                //
                // out += '<span class="block2-price m-text6 p-r-5">';
                // out += '$' + data[key]['price'] + '';
                // out += '</span>';
                // out += '</div>';
                // out += '</div>';
                // out += '</div>';


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
        url: "http://localhost:8080/category",
        type: "GET",
        headers: {
            "Authorize": "Bearer " + localStorage.getItem("token")
        },
        contentType: "application/json",
        success: function (data) {
            var out = '';
            for (var key in data) {
                out += '<li class="p-t-4">';
                out += '<button class="findByCategory" data-id="' + data[key]['id'] + '">' + data[key].nameCategory + '</button>';
                out += '</a>';
                out += '</li>';
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

