	LiveWidgets.addWidget({
    	name: 'next-steps',
    	model: {

    	},
    	controller: {
            handleMessage: function (message)
            {
                if (message == "idea-submitted")
                {
                    $(this.element).show().css({
                        opacity: 0,
                        overflow: "hidden"
                    }).animate({
                        height: "300px",
                        opacity: 1
                    }, 300);
                }
            }
    	},
    	constructor: function () {

    	},
    	reinit: function () {

    	}
    });
