$(document).ready(function () {

    var path=$("#path").val();
    $(".showResourcelist").on("click",function(){

        var obj = $(this);
        window.location.href=path+"/resource/resourceList/"+ obj.attr("roleId");
    })


});