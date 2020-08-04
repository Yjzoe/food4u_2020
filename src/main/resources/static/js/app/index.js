var main = {
    init: function () {
        var _this = this;
        $('#btn_insert').on('click', function () {
            _this.insert();
        });
    },
    insert: function () {
        var formData = new FormData(document.getElementById('f'))
        $.ajax({
            url:"insertGoods",
            data:formData,
            type:"POST",
            processData:false,
            contentType:false,
            dataType: JSON.stringify(formData),
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