
$(document).ready(function () {
	
	var $j = jQuery.noConflict();
	
	var screenWidth = $(window).width();
	if (screenWidth <= 600){
	    changeLabelsForSmall();		
	}
});



function changeLabelsForSmall(){
	$j(".lblUltimo").text("Ultimo");
	$j(".lblMOC").text("Compra");
	$j(".lblMOV").text("Venda");
	$j(".lblData").text("Data");
}