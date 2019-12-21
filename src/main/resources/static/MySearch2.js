$.extend({
    myMethod: function (id,tagData,name) {
    	
    	var html  =  '<div class="layui-form-item">';
			html +=		 '<label class="col-sm-2 control-label">已选择:</label>';
			html +=		 '<div class="AD">';
			html +=		 '</div>';
			html +=	 '</div>';
			// html +=	 '<div class="layui-form-item">';
        	// html +=	   		'<label class="col-sm-2 control-label">选择</label>';
			// html +=	     '<div class="layui-input-inline fileId layui-form-select layui-form-selected">';
        	// html +=			'<input id="fs" type="text" class="form-control" placeholder="输入或选择" autocomplete="off">';
        	// html +=		   	'<dl style="display: none;"></dl>';
			// html +=		 '</div>';
			// html +=	 '</div>';
    	$(id).append(html)
        $(".AD").parent().hide();
	    //获取当前广告

	    $("#clsCli").on("change",function(){
	    	//
			// alert("点击了......");
            var id = $("#cname").val();
            // alert(id);
            $.ajax({
                type:"get",
                url:"/classes/findByClass?clsId="+id,
                async : true,
                cache: false,
                data:null,  //重点必须为一个变量如：data
                dataType:"json",
                success:function(data){
                    tagData=data;
					// for (var i=0;i<tagData.length;i++){
					// 	alert("id为:"+tagData[i].id+"学生名字:"+tagData[i].name);
					// }
                    $(".AD").html("");
                    for (var i=0;i<tagData.length;i++){
                        // alert("id为:"+tagData[i].id+"学生名字:"+tagData[i].name);
                        // $(".AD").append('<a href="javascript:;" class="label"><span lay-value="64">'+$(this).html()+'</span><input type="hidden" name="'+name+'" id="'+$(this).html()+'" value="'+id+'"/><i class="layui-icon close">x</i></a>')
                        $(".AD").append('<a href="javascript:;" class="label"><span lay-value="64">'+tagData[i].name+'</span><input type="hidden" name="sid" id="'+$(this).html()+'" value="'+tagData[i].id+'"/><i class="layui-icon close">x</i></a>')
                        $(".AD").parent().show();
                            // if(tagData[i].id == id){
                            //     tagData.splice(i,1);
                            // }
                    }
                },
                error:function(data){
                    alert("删除失败,请联系管理员");
                }
            });



	    	$(".fileId dl").hide();
	    	$(".fileId input").val("");
		})

        // $(".fileId").on("click","dl dd",function(){
        //     var id = $(this).attr("value");
        //     if(id!=undefined){
        //         // $(".AD").append('<a href="javascript:;" class="label"><span lay-value="64">'+$(this).html()+'</span><input type="hidden" name="'+name+'" id="'+$(this).html()+'" value="'+id+'"/><i class="layui-icon close">x</i></a>')
        //         $(".AD").append('<a href="javascript:;" class="label"><span lay-value="64">'+$(this).html()+'</span><input type="hidden" name="sid" id="'+$(this).html()+'" value="'+id+'"/><i class="layui-icon close">x</i></a>')
        //         $(".AD").parent().show();
        //         for(var i=0;i<tagData.length;i++){
        //             if(tagData[i].id == id){
        //                 tagData.splice(i,1);
        //             }
        //         }
        //     }
        //     $(".fileId dl").hide();
        //     $(".fileId input").val("");
        // })
		
		function AD(name,id){
            this.name=name;
            this.id=id;
        }
	    
	 	//删除当前广告
		$(".AD").on("click",".close",function(){
			$(this).parent().remove();
			var id = $(this).parent().children("input").val();
			var text = $(this).parent().children("input").attr("id");
			tagData.push(new AD(text,id))
		})
		
		//筛选
	    $(".fileId input").on("input propertychange",function(){

	    	$(".fileId dl dd").remove();
	    	$(".fileId dl").hide();
            //
            name=$(".fileId input").val()
            // alert("输入为:"+name)
            $.ajax({
                type:"get",
                url:"/student/findByName?name="+name,
                async : true,
                cache: false,
                data:null,  //重点必须为一个变量如：data
                dataType:"json",
                success:function(data){
                    tagData=data
                },
                error:function(data){
                    alert("删除失败,请联系管理员");
                }
            });
            //
    		if(tagData.length>0){
    			$(".fileId dl").show();    		
    			var sear = new RegExp($(this).val())
    			var temp=0;
	    		for(var i=0;i<tagData.length;i++){
	    			if(sear.test(tagData[i].name)){
	    				temp++
		    			// $(".fileId dl").append('<dd value="'+tagData[i].id+'">'+tagData[i].name+'</dd>')
                        $(".fileId dl").append('<dd value="'+tagData[i].id+'">'+tagData[i].name+':'+tagData[i].sphone+'</dd>')
	    			}
	    		}
	    		if(temp==0){
	    			// $(".fileId dl").append('<dd>暂无数据</dd>')
                    $(".fileId dl").append('<dd></dd>')
	    		}
    		}
	   	})	
	   	
	   	//隐藏
	   	$(document).click(function(){
			$(".fileId dl").hide();
	    	$(".fileId input").val("");
		});
	 	
	 	//显示没被选择的
		$(".fileId input").click(function(event){
			$(".fileId dl dd").remove();
	    	if(tagData.length==0){
				$(this).val("暂无数据")
	    	}else{
		    	$(".fileId dl").show()
	    	}
	    	for(var i=0;i<tagData.length;i++){
	    		$(".fileId dl").append('<dd value="'+tagData[i].id+'">'+tagData[i].name+'</dd>')
    		}
			event.stopPropagation();
		});
	//
    //     $("#fs").keyup(function () {
    //     	var name=$("#fs").val();
    //         $.ajax({
    //             type:"get",
    //             url:"/testData?name="+name,
    //             async : true,
    //             // cache: false,
    //             data:null,  //重点必须为一个变量如：data
    //             dataType:"json",
    //             success:function(data){
    //             	// alert(data)
    //                 // alert(JSON.stringify(data))
    //                 tagData=data
    //                 // $.myMethod("#demo",tagData,"fileIds")
    //                 // $(".sumbit").on("click",function(){
    //                 //     console.log($("form").serialize())
    //                 // })
    //                 // tagData=JSON.stringify(data)
    //             },
    //             error:function(data){
    //                 alert("删除失败,请联系管理员");
    //             }
    //         });
    //     });
	//

    }
});