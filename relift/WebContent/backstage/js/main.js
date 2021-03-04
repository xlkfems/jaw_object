/*
* @Author: Larry
* @Date:   2016-12-15 17:20:54
* @Last Modified by:   qinsh
* @Last Modified time: 2016-12-24 21:51:08
* +----------------------------------------------------------------------
* | LarryBlogCMS [ LarryCMS网站内容管理系统 ]
* | Copyright (c) 2016-2017 http://www.larrycms.com All rights reserved.
* | Licensed ( http://www.larrycms.com/licenses/ )
* | Author: qinshouwei <313492783@qq.com>
* +----------------------------------------------------------------------
*/
var myChart = echarts.init(document.getElementById('larry-seo-stats'));
option = {
    title : {
        text: '本月货运情况',
        subtext: '',
        x:'center'
    },
    tooltip : {
        trigger: 'item',
        formatter: "{a} <br/>{b} : {c} ({d}%)"
    },
    legend: {
        orient: 'vertical',
        left: 'left',
        data: ['四川省','广东省','福建省','浙江省','湖南省']
    },
    series : [
        {
            name: '货运量',
            type: 'pie',
            radius : '55%',
            center: ['50%', '60%'],
            data:[
                {value:335, name:'四川省'},
                {value:310, name:'广东省'},
                {value:234, name:'福建省'},
                {value:135, name:'浙江省'},
                {value:1548, name:'湖南省'}
            ],
            itemStyle: {
                emphasis: {
                    shadowBlur: 10,
                    shadowOffsetX: 0,
                    shadowColor: 'rgba(0, 0, 0, 0.5)'
                }
            }
        }
    ]
};
myChart.setOption(option);
