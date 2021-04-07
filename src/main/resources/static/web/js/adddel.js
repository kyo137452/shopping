$(function() {
	//地址管理點擊刪除時的提示
	$(".add-del").click(function() {
			if (confirm("確定刪除這個地址嗎？")) {
				location.href = "address.html";
			}
		})
		//點擊設定為預設地址時的效果
	$(".add-def").click(function() {
		$(".add-def").show();
		$(this).hide();
	})
	$(".add-def:eq(0)").hide();
})













