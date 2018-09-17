function SelCity1(obj, e) {
    var ths = obj;
    var dal = '<div class="_citysD"><span title="关闭" id="cColse" >×</span><div id="_citysheng1" class="_citys01">请选择省份</div><div id="_citys01" class="_citys11"></div><div style="display:none" id="_citys11" class="_citys11"></div><div style="display:none" id="_citys21" class="_citys11"></div></div>';
    Iput.show({
        id: ths,
        event: e,
        content: dal,
        width: "470"
    });
    $("#cColse").click(function() {
        Iput.colse()
    });
    var tb_province1 = [];
    var b = province1;
    for (var i = 0,
             len = b.length; i < len; i++) {
        tb_province1.push('<a data-id="' + b[i]['id'] + '" id="' + b[i]['id'] + '" data-name="' + b[i]['name'] + '" title="' + b[i]['name'] + '">' + b[i]['name'] + '</a>')
    }

    $("#_citys01").append(tb_province1.join(""));
    $("#_citys01 a").click(function() {
        var val = $(this).attr("id");
        var content=document.getElementById(val).innerText;
        // alert(content);
        $("#_citys11 a").remove();
        $("#_citys11").hide();
        $("#_citys01").hide();
        $("._citys01").hide();
        $("._citys11").hide();
        // $("._citys11:eq(1)").show();
        $("#_citys01 a,#_citys11 a,#_citys21 a").removeClass("AreaS");
        var lev = $(this).data("name");
        ths.value = content;

        chart2(content);

        $("#_citys1 a").click(function() {
            $("#_citys1 a,#_citys2 a").removeClass("AreaS");
            $(this).addClass("AreaS");
            var lev = $(this).data("name");

            var bc = $("#hcity").val();
            ths.value = bc + "/" + $(this).data("name");
            var ar = getArea($(this));
            $("#_citys2 a").remove();
            if (ar == '') Iput.colse();
            $("#_citys2").append(ar);
            $("._citys1").hide();
            $("._citys1:eq(2)").show();
            $("#_citys2 a").click(function() {
                $("#_citys2 a").removeClass("AreaS");
                $(this).addClass("AreaS");
                var lev = $(this).data("name");

                var bc = $("#hcity").val();
                var bp = $("#hproper").val();
                ths.value = bc + "/" + bp + "/" + $(this).data("name");
                Iput.colse()
            })
        })
    })
}
