/**
 * Created by cxd on 2016/9/10.
 */
(function($){
    $.fn.serializeJson=function(serializeObj){
        if(serializeObj == null){
            var serializeObj={};
        }
        $(this.serializeArray()).each(function(){
            serializeObj[this.name]=this.value;
        });
        return serializeObj;
    };
})(jQuery);
