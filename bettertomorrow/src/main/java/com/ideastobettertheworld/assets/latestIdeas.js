	LiveWidgets.addWidget({
    	name: 'latest-ideas',
    	model: {

    	},
    	controller: {
            handleMessage: function (message)
            {
                console.log("Message Recieved");
                console.log(message);
                if(message == "show-latest-ideas")
                {
                    $(this.element).show().css({
                        opacity: 0,
                        overflow: "hidden"
                    }).animate({
                        height: "90%",
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
