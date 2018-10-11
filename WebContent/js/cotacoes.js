
$(document).ready(function () {
	var screenWidth = $(window).width();
	if (screenWidth <= 600){
	    changeLabelsForSmall();		
	}
});



function changeLabelsForSmall(){
	$(".lblUltimo").text("Ultimo");
	$(".lblMOC").text("Compra");
	$(".lblMOV").text("Venda");
	$(".lblData").text("Data");
}