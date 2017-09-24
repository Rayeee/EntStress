<html>
	<head>
		<script src="https://unpkg.com/vue"></script>
	</head>

<body>
	<div id="app">
		{{ message }}
	</div>
</body>

<script type="text/javascript">
    var app = new Vue({
        el: '#app',
        data: {
            message: 'Hello World!'
        }
    })
</script>

</html>