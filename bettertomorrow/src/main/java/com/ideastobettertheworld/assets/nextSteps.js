	LiveWidgets.addWidget({
    	name: 'next-steps',
    	model: {

    	},
    	controller: {
            handleMessage: function (message)
            {
                if(message == "idea-submitted")
                {
                    $(this.element).show().css({
                        opacity: 0,
                        overflow: "hidden"
                    }).animate({
                        height: "300px",
                        opacity: 1
                    }, 300);
                }
                if (message == "show-latest-ideas")
                {
                    $(this.element).animate({
                        height: "0px",
                        opacity: 0
                    }, 300, function () {
                        $(this.element).hide();
                    }.bind(this));
                }
            }
    	},
    	constructor: function () {

    	},
    	reinit: function () {

    	}
    });
