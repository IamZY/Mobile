var xmlHttpRequest = null;
		
function getXMLHttpRequest() {
	try {
		xmlHttpRequest = new XMLHttpRequest();
	}
	catch (e) {
		try {
			xmlHttpRequest = new ActiveXObject("Msxml2.XMLHTTP");
		}
		catch (e2) {
			xmlHttpRequest = new ActiveXObject("Microsoft.XMLHTTP");
		}
	}
}

