var main = {
    init: function () {
        var _this = this;
        $('#btn_insert').on('click', function () {
            _this.insert();
        });
    },
    insert: function () {

        var img = "";
        // if ($('#uploadFile').val().length > 0) {
        //     var x;
        //     img = x;
        // }

        var data = {
            name : $('#name').val(),
            price: $('#price').val(),
            type : $('#type').val(),
            stock : $('#stock').val(),
            fname : img,
            nutrients : null,
            compositions : null
        };
        alert(data.name)
        $.ajax({
            url:"insertGoods",
            data:data,
            type:"POST",
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data),
            success:function(re){
                alert("성공")
                // addNutrient()
                // addComposition()
            }
        })

        addNutrient = function () {
            var g_no =  $('#g_no').val()
            var kcal = Math.round($('#kcal').val())
            var carbohydrate = Math.round($('#carbohydrate').val())
            var protein = Math.round($('#protein').val())
            var fat = Math.round($('#fat').val())
            var sugar = Math.round($('#sugar').val())
            var natrium = Math.round($('#natrium').val())
            var cholesterol = Math.round($('#cholesterol').val())
            var fatty_acid = Math.round($('#fatty_acid').val())
            var transfatty_acid = Math.round($('#transfatty_acid').val())
            var n_name = ["kcal","carbohydrate","protein","fat","sugar","natrium","cholesterol","fatty_acid","transfatty_acid"]
            var arr = [kcal,carbohydrate,protein,fat,sugar,natrium,cholesterol,fatty_acid,transfatty_acid]

            for(var i=0;i<arr.length;i++){
                $.ajax({url:"insertNutrient",type:"POST",data:{"g_no":g_no,"n_name":n_name[i],"qty":arr[i]}})
            }
        }

        addComposition = function(){ //구성 추가하는 기능
            var cnt = 0;
            var g_no =  $('#g_no').val()
            for(var i=0;i<=cnt;i++)
            {
                var foodName = $('#foodName'+i).val()
                if(foodName.length>0){
                    var data = {"g_no":g_no,"foodname":foodName}
                    $.ajax({url:"insertComposition",type:"POST",data:data})
                }
            }
        }
    }
}

main.init()