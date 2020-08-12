var main = {
    init: function () {
        var _this = this;
        $('#btn_insert').on('click', function () {
            _this.insert();
        });

        $('#btnFoodAdd').on('click', function () {
            _this.searchFood();
        });
    },
    addNutrient : function () {
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
    },
    addComposition : function(){
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
            fname : img
        };
        $.ajax({
            url:"insertGoods",
            data:data,
            type:"POST",
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data),
            success:function(re){
                alert("성공")
                this.addNutrient()
                this.addComposition()
            }
        })
    },
    searchFood: function () {
        var foodname = $('#food').val();
        var pageNum = $('#pageNumber').val();
        var data = {"foodname": foodname, "pageNum": pageNum}
        $('#composition2').empty();
        var totalCount;
        $.ajax({
            url: "SearchFood",
            data: data,
            success: function (re) {
                var menu = $('<tr><td>음식이름</td><td>1회제공량</td><td>칼로리</td><td>탄수화물</td><td>단백질</td><td>지방</td><td>당류</td><td>나트륨</td><td>콜레스테롤</td><td>포화지방</td><td>트랜스지방</td></tr>')
                $('#composition2').append(menu);
                $.each(re, function (idx, f) {
                    totalCount = f.totalCount;
                    var tr = $('<tr></tr>')
                    var td1 = $('<td></td>').html(f.foodname);
                    var td2 = $('<td></td>').html(f.serving + "g");
                    var td3 = $('<td></td>').html(f.kcal);
                    var td4 = $('<td></td>').html(f.carbohydrate);
                    var td5 = $('<td></td>').html(f.protein);
                    var td6 = $('<td></td>').html(f.fat);
                    var td7 = $('<td></td>').html(f.sugar);
                    var td8 = $('<td></td>').html(f.natrium);
                    var td9 = $('<td></td>').html(f.cholesterol);
                    var td10 = $('<td></td>').html(f.fatty_acid);
                    var td11 = $('<td></td>').html(f.transfatty_acid);

                    $(tr).append(td1, td2, td3, td4, td5, td6, td7, td8, td9, td10, td11);
                    $('#composition2').append(tr);
                    $('#pageNum').css("visibility", "visible")

                    var totalPage = 0;
                    if (totalCount % 5 == 0) {
                        totalPage = Math.round(totalCount / 5);
                    } else {
                        totalPage = Math.round((totalCount / 5) + 1);
                    }

                    $('#totalPage').html(totalPage)

                    $(tr).click("on", function () {
                        var tds = $(this).find('td');
                        var foodname = $(tds[0]).html()
                        var serving = $(tds[1]).html()
                        var kcal = eval($(tds[2]).html())
                        var carbohydrate = eval($(tds[3]).html())
                        var protein = eval($(tds[4]).html())
                        var fat = eval($(tds[5]).html())
                        var sugar = eval($(tds[6]).html())
                        var natrium = eval($(tds[7]).html())
                        var cholesterol = eval($(tds[8]).html())
                        var fatty_acid = eval($(tds[9]).html())
                        var transfatty_acid = eval($(tds[10]).html())
                        var btn = $('<button></button>').attr({"id": "btn_NDel", "type": "button"}).html("-");

                        var span = $('<span></span>').html(foodname)
                        var cnt = 0;
                        // last +cnt delete
                        var input = $('<input/>').attr({"type": "hidden", "id": "foodName"}).val(foodname + cnt);

                        var div = $('<div></div>').append(span, btn)

                        $('#composition').append(input)

                        $('#foodNutrient').append(div)

                        if (($('#kcal').val()).length == 0) {
                            cnt = cnt + 1;
                            $('#kcal').val(kcal)
                            $('#carbohydrate').val(carbohydrate)
                            $('#protein').val(protein)
                            $('#fat').val(fat)
                            $('#sugar').val(sugar)
                            $('#natrium').val(natrium)
                            $('#cholesterol').val(cholesterol)
                            $('#fatty_acid').val(fatty_acid)
                            $('#transfatty_acid').val(transfatty_acid)
                        } else {
                            cnt = cnt + 1;
                            $('#kcal').val(eval($('#kcal').val()) + eval(kcal))
                            $('#carbohydrate').val(eval($('#carbohydrate').val()) + eval(carbohydrate))
                            $('#protein').val(eval($('#protein').val()) + eval(protein))
                            $('#fat').val(eval($('#fat').val()) + eval(fat))
                            $('#sugar').val(eval($('#sugar').val()) + eval(sugar))
                            $('#natrium').val(eval($('#natrium').val()) + eval(natrium))
                            $('#cholesterol').val(eval($('#cholesterol').val()) + eval(cholesterol))
                            $('#fatty_acid').val(eval($('#fatty_acid').val()) + eval(fatty_acid))
                            $('#transfatty_acid').val(eval($('#transfatty_acid').val()) + eval(transfatty_acid))
                        }
                        $(btn).click("on", function () { //추가해놓은거 지우는 기능

                            $('#kcal').val(eval($('#kcal').val()) - eval(kcal))
                            $('#carbohydrate').val(eval($('#carbohydrate').val()) - eval(carbohydrate))
                            $('#protein').val(eval($('#protein').val()) - eval(protein))
                            $('#fat').val(eval($('#fat').val()) - eval(fat))
                            $('#sugar').val(eval($('#sugar').val()) - eval(sugar))
                            $('#natrium').val(eval($('#natrium').val()) - eval(natrium))
                            $('#cholesterol').val(eval($('#cholesterol').val()) - eval(cholesterol))
                            $('#fatty_acid').val(eval($('#fatty_acid').val()) - eval(fatty_acid))
                            $('#transfatty_acid').val(eval($('#transfatty_acid').val()) - eval(transfatty_acid))

                            $(span).html()

                            for (var i = 0; i <= cnt; i++) {
                                if (foodname == ($('#foodName' + i).val())) {
                                    $('#foodName' + i).remove();
                                    break;
                                }

                            }
                            $(div).remove();
                        });
                    })
                })
            }
        })
    }
}

main.init()