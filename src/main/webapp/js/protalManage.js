

function getProtalList(pageNo) {
    $("#pageNo").val(pageNo);

    formsubmit();
}
function formsubmit() {
    document.getElementById("protalForm").submit();
}