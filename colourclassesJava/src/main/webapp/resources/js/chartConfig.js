var config = {
			type: 'line',
			data: {
				labels: [],
				datasets: [{
					label: 'In Transit',
					fill: false,
					backgroundColor: window.chartColors.blue,
					borderColor: window.chartColors.blue,
					data: [],
				}]
			},
			options: {
				responsive: true,
				title: {
					display: false,
					text: 'Total number of trips'
				},
				tooltips: {
					mode: 'index',
					intersect: false,
				},
				hover: {
					mode: 'nearest',
					intersect: true
				},
				scales: {
					xAxes: [{
						display: true,
						scaleLabel: {
							display: true,
							labelString: 'Days'
						}
					}],
					yAxes: [{
						display: true,
						scaleLabel: {
							display: true,
							labelString: 'Count'
						}
					}]
				}
			}
		};
		
		var config1 = {
				type: 'line',
				data: {
					labels: [],
					datasets: [{
						label: 'Delivery Complete',
						fill: false,
						backgroundColor: window.chartColors.blue,
						borderColor: window.chartColors.blue,
						data: [],
					}]
				},
				options: {
					responsive: true,
					title: {
						display: false,
						text: 'Total number of trips'
					},
					tooltips: {
						mode: 'index',
						intersect: false,
					},
					hover: {
						mode: 'nearest',
						intersect: true
					},
					scales: {
						xAxes: [{
							display: true,
							scaleLabel: {
								display: true,
								labelString: 'Days'
							}
						}],
						yAxes: [{
							display: true,
							scaleLabel: {
								display: true,
								labelString: 'Count'
							}
						}]
					}
				}
			};