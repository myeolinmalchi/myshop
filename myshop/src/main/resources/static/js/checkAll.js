$(document).ready(
    function checkAll(){
        $("#checkAll").click(function(){
            if($("#checkAll").prop("checked")){
                $("input[name=checkbox]").prop("checked",true);
            }else{
                $("input[name=checkbox]").prop("checked",false);
            }
        })
    }
)