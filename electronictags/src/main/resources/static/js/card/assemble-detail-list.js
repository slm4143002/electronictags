$(function() {
	initTable();
	function initTable() {
		$('#assemble_dataTable').bootstrapTable('destroy').bootstrapTable({
			height: 550,
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
					field: 'ticketInfo',
					title: '小票内容',
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
					field: 'machineCount',
					title: '台数',
					align: 'center',
					sortable: false,
				},
				{
					field: 'writeDate',
					title: '日期',
					align: 'center',
					sortable: false,
				},
				{
					field: 'assembleResult',
					title: '组装结果',
					align: 'center',
					sortable: false,
				},
				{
					field: 'groundConnectionResult',
					title: '接地结果',
					align: 'center',
					sortable: false,
				},
				{
					field: 'withstandVoltageResult',
					title: '耐压结果',
					align: 'center',
					sortable: false,
				},
				{
					field: 'utResult',
					title: 'UT结果',
					align: 'center',
					sortable: false,
				},
				{
					field: 'checkResult',
					title: '本批量结果',
					align: 'center',
					sortable: false,
				},
				{
					field: 'cardBindingNumber',
					title: '电子卡片信息',
					align: 'center',
					sortable: false,
				}
			],
		})
	}

});
