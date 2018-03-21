$(function() {
	var uploader = WebUploader.create({
		
	    // swf文件路径
	    swf: '/js/Uploader.swf',
	
	    // 文件接收服务端。
	    server: 'upload.action',
	
	    // 选择文件的按钮。可选。
	    // 内部根据当前运行是创建，可能是input元素，也可能是flash.
	    pick: '#picker',
	
	    // 不压缩image, 默认如果是jpeg，文件上传前会压缩一把再上传！
	    resize: false
	});
	
	var $list = $('#thelist');
	// 当有文件被添加进队列的时候
	uploader.on( 'fileQueued', function( file ) {
	    $list.append( '<div id="' + file.id + '" class="item">' +
	        '<h4 class="info">' + file.name + '</h4>' +
	        '<p class="state">等待上传...</p>' +
	    '</div>' );
	});
	$("#ctlBtn").click(function () {
	    uploader.upload();
	});
	//文件上传成功
	uploader.on( 'uploadSuccess', function( file ) {
	    $( '#'+file.id ).find('p.state').text('已上传');
	});
});