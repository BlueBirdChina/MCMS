<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<script src="http://yui.yahooapis.com/3.18.1/build/yui/yui-min.js"></script>
<script>
	// Create a new YUI instance and populate it with the required modules.
	YUI().use('datatable', function(Y) {
		var data = [ {
			id : "ga-3475",
			name : "gadget",
			price : "$6.99",
			cost : "$5.99"
		}, {
			id : "sp-9980",
			name : "sprocket",
			price : "$3.75",
			cost : "$3.25"
		}, {
			id : "wi-0650",
			name : "widget",
			price : "$4.25",
			cost : "$3.75"
		} ];

		var table = new Y.DataTable({
			columns : [ "id", "name", "price" ],
			data : data,

			// Optionally configure your table with a caption
			caption : "My first DataTable!",

			// and/or a summary (table attribute)
			summary : "Example DataTable showing basic instantiation configuration"
		});

		table.render("#example");
	});
	// Create a new YUI instance and populate it with the required modules.
	YUI().use('gallery-yui3treeview', function (Y) {
	     var treeview = new Y.TreeView({  
	     srcNode: '#treeDiv1',
	     contentBox: null,
	     type: "TreeView",
	     children: [
	                   {
	                      label: "level1-1",
	                      type: "TreeView",
	                      children: [
	                          {label: "level2-1"},
	                          {label: "level2-2"}
	                      ]
	                   },
	                   {
	                       type: "TreeView",
	                      label : "level1-2"
	                  }
	               ]
			});
			 
			treeview.render();
	});
</script>
</head>
<body class="yui3-skin-sam">
	<div id="example"></div>
	<div id="treeDiv1"></div> 
</body>
</html>