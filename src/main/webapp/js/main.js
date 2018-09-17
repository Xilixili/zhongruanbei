
	        var dlNum = $("#aui-selectList").find("dl");
	        for (i = 0; i < dlNum.length; i++) {
	            $(".aui-screen-head-choice .aui-clear-list").append("<div class=\"aui-selected-info selectedShow\" style=\"display:none\"><span></span><label></label><em></em></div>");
	        }
	        var refresh = "true";
	        $(".aui-screen-list-item a ").live("click", function() {
	            var text = $(this).text();
	            var selectedShow = $(".selectedShow");
	            var textTypeIndex = $(this).parents("dl").index();
	            var textType = $(this).parent("dd").siblings("dt").text();
	            index = textTypeIndex - (2);
	            $(".aui-clear-delete").show();
	            $(".selectedShow").eq(index).show();
	            $(this).addClass("selected").siblings().removeClass("selected");
	            selectedShow.eq(index).find("span").text(textType);
	            selectedShow.eq(index).find("label").text(text);
	            var show = $(".selectedShow").length - $(".selectedShow:hidden").length;
	            if (show > 1) {
	                $(".aui-eliminate").show();
	            }

	        });
	        $(".selectedShow em").live("click", function() {
	            $(this).parents(".selectedShow").hide();
	            var textTypeIndex = $(this).parents(".selectedShow").index();
	            index = textTypeIndex;
	            $(".aui-screen-list-item").eq(index).find("a").removeClass("selected");

	            if ($(".aui-screen-list-item .selected").length < 2) {
	                $(".aui-eliminate").hide();
	            }
	        });

	        $(".aui-eliminate").live("click", function() {
	            $(".selectedShow").hide();
	            $(this).hide();
	            $(".aui-screen-list-item a ").removeClass("selected");
	        });