$(function() {
	initTable();
	function initTable() {
		$('#assemble_dataTable').bootstrapTable('destroy').bootstrapTable({
			height: 650,
			sortable: true, // 是否启用排序
			sortOrder: "asc",
			columns: [
				[{
					field: 'batchNumber',
					title: '批量号',
					sortable: false,
					align: 'center',
					valign:"middle",
					colspan: 1,
                    rowspan: 2

				},
				{
					field: 'ticketInfo',
					title: '小票内容',
					sortable: false,
					align: 'center',
					valign:"middle",
					colspan: 1,
                    rowspan: 2
				},
				{
					field: 'machineCategoryName',
					title: '机种名称',
					sortable: false,
					align: 'center',
					valign:"middle",
					colspan: 1,
                    rowspan: 2
				},
				{
					field: 'machineCount',
					title: '台数',
					align: 'center',
					valign:"middle",
					sortable: false,
					colspan: 1,
                    rowspan: 2,
                    formatter: function (value,row) {
			            return  row.pieceTimes + "/" + value;
			        }
				},
				{
					field: 'writeDate',
					title: '日期',
					align: 'center',
					valign:"middle",
					sortable: false,
					colspan: 1,
                    rowspan: 2
				},
				{
					title: '组装结果',
					align: 'center',
					sortable: false,
					colspan: 2,
                    rowspan: 1
				},
				{
					title: '接地结果',
					align: 'center',
					sortable: false,
					colspan: 2,
                    rowspan: 1
				},
				{
					title: '耐压结果',
					align: 'center',
					sortable: false,
					colspan: 2,
                    rowspan: 1
				},
				{
					title: 'UT结果',
					align: 'center',
					sortable: false,
					colspan: 2,
                    rowspan: 1
				},
				{
					field: 'checkResult',
					title: '本批量结果',
					align: 'center',
					valign:"middle",
					sortable: false,
					colspan: 1,
                    rowspan: 2
				},
				{
					field: 'cardBindingNumber',
					title: '电子卡片信息',
					valign:"middle",
					align: 'center',
					sortable: false,
					colspan: 1,
                    rowspan: 2
				}],
				[{
					field: 'assembleResult',
					title: '状态',
					align: 'center',
					sortable: false,
				},{
					field: 'assembleResultLo',
					title: 'L/O',
					align: 'center',
					sortable: false,
				},{
					field: 'groundConnectionResult',
					title: '状态',
					align: 'center',
					sortable: false,
				},{
					field: 'groundConnectionResultLo',
					title: 'L/O',
					align: 'center',
					sortable: false,
				},{
					field: 'withstandVoltageResult',
					title: '状态',
					align: 'center',
					sortable: false,
				},{
					field: 'withstandVoltageResultLo',
					title: 'L/O',
					align: 'center',
					sortable: false,
				},{
					field: 'utResult',
					title: '状态',
					align: 'center',
					sortable: false,
				},{
					field: 'utResultLo',
					title: 'L/O',
					align: 'center',
					sortable: false,
				}]
			],
			mergeCells: {
		    index: 1,
		    colspan: 2,
		  	}
		})
	}

});
