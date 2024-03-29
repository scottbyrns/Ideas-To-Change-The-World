	LiveWidgets.addWidget({
    	name: 'latest-ideas',
    	model: {

    	},
    	controller: {
    	    hidePanel: function ()
    	    {
                    /* Probably acts strange when scrolled and you dismiss. */
                    $(this.element).css({
                        overflow: "hidden"
                    }).animate({
                        height: "0%",
                        opacity: 0
                    }, 300);
    	    },
            handleMessage: function (message)
            {
                console.log("Message Recieved");
                console.log(message);
                if(message == "show-latest-ideas")
                {
                    $(this.element).show().css({
                        marginTop: "50px",
                        opacity: 0,
                        overflow: "hidden"
                    }).animate({
                        height: "100%",
                        opacity: 1
                    }, 300, function () {
                        $(this.element).css({
                           overflow: "visible"
                        });
                    }.bind(this));
                }

                if (message == "show-idea-share-form")
                {
                    this.controller.hidePanel();
                }

                if (message == "hide-all-ideas-panels")
                {
                    this.controller.hidePanel();
                }
            }
    	},
    	constructor: function () {

    	},
    	reinit: function () {

    	}
    });
