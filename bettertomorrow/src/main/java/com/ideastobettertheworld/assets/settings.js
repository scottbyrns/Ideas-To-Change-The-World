	LiveWidgets.addWidget({
    	name: 'settings',
    	model: {

    	},
    	controller: {
            handleMessage: function (message)
            {
                if (message == "show-latest-ideas")
                {
                    this.controller.hidePanel();
                }

                if (message == "show-idea-share-form")
                {
                    this.controller.hidePanel();
                }

                if (message == "show-settings")
                {
                    this.controller.showPanel();
                }
            },

            showPanel: function ()
            {
                $(this.element).show().show().css({
                    top: ($(window).height() + $(this.element).height()) + "px"
                }).animate({
                    top: "150px"
                }, 300);
            },

            hidePanel: function ()
            {
                $(this.element).animate({
                    top: ($(window).height() + $(this.element).height()) + "px"
                }, 300, function () {
                    $(this.element).hide();
                }.bind(this));
            }
    	},
    	constructor: function () {
            $("a.blue", this.element).bind("click", this.controller.hidePanel);
    	},
    	reinit: function () {

    	}
    });
