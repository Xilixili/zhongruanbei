function SelCity2(obj, e) {
    var ths = obj;
    var dal = '<div class="_citysD1"><span title="关闭" id="cColse11" >×</span><div id="_citysheng11" class="_citys011">请选择省份</div><div id="_citys011" class="_citys111"></div><div style="display:none" id="_citys111" class="_citys111"></div><div style="display:none" id="_citys211" class="_citys111"></div></div>';
    Iput.show({
        id: ths,
        event: e,
        content: dal,
        width: "470"
    });
    $("#cColse11").click(function() {
        Iput.colse()
    });
    var tb_province11 = [];
    var b = province1;
    for (var i = 0,
             len = b.length; i < len; i++) {
        tb_province11.push('<a data-id="' + b[i]['id'] + '" id="' + b[i]['id'] + '" data-name="' + b[i]['name'] + '" title="' + b[i]['name'] + '">' + b[i]['name'] + '</a>')
    }

    $("#_citys011").append(tb_province11.join(""));
    $("#_citys011 a").click(function() {
        var val = $(this).attr("id");
        var content=document.getElementById(val).innerText;
        // alert(content);
        $("#_citys111 a").remove();
        $("#_citys111").hide();
        $("#_citys011").hide();
        $("._citys011").hide();
        $("._citys111").hide();
        // $("._citys11:eq(1)").show();
        $("#_citys011 a,#_citys111 a,#_citys211 a").removeClass("AreaS");
        var lev = $(this).data("name");
        ths.value = content;

        chart3(content);

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
