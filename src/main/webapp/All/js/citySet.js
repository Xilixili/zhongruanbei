function SelCity(obj, e) {
    var ths = obj;
    var dal = '<div class="_citys"><span title="关闭" id="cColse" >×</span><div id="_citysheng" class="_citys0">请选择行业</div><div id="_citys0" class="_citys1"></div><div style="display:none" id="_citys1" class="_citys1"></div><div style="display:none" id="_citys2" class="_citys1"></div></div>';
    Iput.show({
        id: ths,
        event: e,
        content: dal,
        width: "470"
    });
    $("#cColse").click(function() {
        Iput.colse()
    });
    var tb_province = [];
    var b = province;
    for (var i = 0,
             len = b.length; i < len; i++) {
        tb_province.push('<a data-id="' + b[i]['id'] + '" id="' + b[i]['id'] + '" data-name="' + b[i]['name'] + '" title="' + b[i]['name'] + '">' + b[i]['name'] + '</a>')
    }

    $("#_citys0").append(tb_province.join(""));
    $("#_citys0 a").click(function() {
        var val = $(this).attr("id");
        var content=document.getElementById(val).innerText;
        // alert(content);
        $("#_citys1 a").remove();
        $("#_citys1").hide();
        $("#_citys0").hide();
        $("._citys0").hide();
        $("._citys").hide();
        $("._citys1:eq(1)").show();
        $("#_citys0 a,#_citys1 a,#_citys2 a").removeClass("AreaS");
        var lev = $(this).data("name");
        // alert(lev);
        ths.value = content;
        chart1(content);

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
