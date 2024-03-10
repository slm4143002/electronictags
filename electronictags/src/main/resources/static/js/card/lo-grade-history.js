$(function() {
	initTable();
	function initTable() {
		$('#grade_dataTable').bootstrapTable('destroy').bootstrapTable({
			height: 600,
			sortable: true, // 是否启用排序
			sortOrder: "asc",
			columns: [
				{
					field: 'batchNumber',
					title: '批量号',
					sortable: false,
					align: 'center',
				},
				{
					field: 'writeDate',
					title: '日期',
					sortable: false,
					align: 'center',
				},
				{
					field: 'machineCategoryName',
					title: '机种名称',
					sortable: false,
					align: 'center',
				},
				{
					field: 'processCategory',
					title: '处理种别',
					align: 'center',
					sortable: false,
				},
				{
					field: 'processResult',
					title: '处理结果',
					align: 'center',
					sortable: false,
				}
			],
		})
	}

});

