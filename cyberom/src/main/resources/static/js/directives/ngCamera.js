module.directive('ngCamera', function($q, $timeout) {
    return {

        'restrict': 'E',
        'scope': {
            'actionMessage': '@',
            'captureMessage': '@',
            'countdown': '@',
            'flashFallbackUrl': '@',
            'overlayUrl': '@',
            'outputHeight': '@',
            'outputWidth': '@',
            'shutterUrl': '@',
            'viewerHeight': '@',
            'viewerWidth': '@',
            'cropHeight': '@',
            'cropWidth': '@',
            'imageFormat': '@',
            'jpegQuality': '@',
            'snapshot': '='
        },
        'templateUrl': '/js/directives/ng-camera.html',
        'link': link
    
    };
    
    function link(scope, element, attrs) {
    	
    	scope.snapshot = 'data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAASwAAAEsCAMAAABOo35HAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAAyRpVFh0WE1MOmNvbS5hZG9iZS54bXAAAAAAADw/eHBhY2tldCBiZWdpbj0i77u/IiBpZD0iVzVNME1wQ2VoaUh6cmVTek5UY3prYzlkIj8+IDx4OnhtcG1ldGEgeG1sbnM6eD0iYWRvYmU6bnM6bWV0YS8iIHg6eG1wdGs9IkFkb2JlIFhNUCBDb3JlIDUuMy1jMDExIDY2LjE0NTY2MSwgMjAxMi8wMi8wNi0xNDo1NjoyNyAgICAgICAgIj4gPHJkZjpSREYgeG1sbnM6cmRmPSJodHRwOi8vd3d3LnczLm9yZy8xOTk5LzAyLzIyLXJkZi1zeW50YXgtbnMjIj4gPHJkZjpEZXNjcmlwdGlvbiByZGY6YWJvdXQ9IiIgeG1sbnM6eG1wPSJodHRwOi8vbnMuYWRvYmUuY29tL3hhcC8xLjAvIiB4bWxuczp4bXBNTT0iaHR0cDovL25zLmFkb2JlLmNvbS94YXAvMS4wL21tLyIgeG1sbnM6c3RSZWY9Imh0dHA6Ly9ucy5hZG9iZS5jb20veGFwLzEuMC9zVHlwZS9SZXNvdXJjZVJlZiMiIHhtcDpDcmVhdG9yVG9vbD0iQWRvYmUgUGhvdG9zaG9wIENTNiAoTWFjaW50b3NoKSIgeG1wTU06SW5zdGFuY2VJRD0ieG1wLmlpZDpCNUY2RkEwRjUzOEQxMUUzQjRFOUM5RDg4RkJDMzY5RCIgeG1wTU06RG9jdW1lbnRJRD0ieG1wLmRpZDpCNUY2RkExMDUzOEQxMUUzQjRFOUM5RDg4RkJDMzY5RCI+IDx4bXBNTTpEZXJpdmVkRnJvbSBzdFJlZjppbnN0YW5jZUlEPSJ4bXAuaWlkOkI1RjZGQTBENTM4RDExRTNCNEU5QzlEODhGQkMzNjlEIiBzdFJlZjpkb2N1bWVudElEPSJ4bXAuZGlkOkI1RjZGQTBFNTM4RDExRTNCNEU5QzlEODhGQkMzNjlEIi8+IDwvcmRmOkRlc2NyaXB0aW9uPiA8L3JkZjpSREY+IDwveDp4bXBtZXRhPiA8P3hwYWNrZXQgZW5kPSJyIj8+GDptigAAAGZQTFRF2NjYt7e3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';

        /**
         * Set default variables
         */
        scope.libraryLoaded = false;
        scope.cameraLive = false;
        scope.activeCountdown = false;
        scope.showCapturedPicture = false;
        scope.cameraStarted = false;

        /**
         * Set dimensions
         */
        if(scope.viewerHeight === undefined) {
            scope.viewerHeight = 'auto';
        }
        if(scope.viewerWidth === undefined) {
            scope.viewerWidth = 'auto';
        }
        if(scope.outputHeight === undefined) {
            scope.outputHeight = scope.viewerHeight;
        }
        if(scope.outputWidth === undefined) {
            scope.outputWidth = scope.viewerWidth;
        }

        /**
         * Disable cropping if one or the two params are undefined
         */
        if(scope.cropHeight === undefined || scope.cropWidth === undefined) {
            scope.cropHeight = false;
            scope.cropWith = false;
        }

        /**
         * Set configuration parameters
         * @type {object}
         */
        /*Webcam.set({
            width: scope.viewerWidth,
            height: scope.viewerHeight,
            dest_width: scope.outputWidth,
            dest_height: scope.outputHeight,
            crop_width: scope.cropWidth,
            crop_height: scope.cropHeight,
            image_format: scope.imageFormat,
            jpeg_quality: scope.jpegQuality,
            force_flash: false
        });*/
        
        Webcam.set({
			// live preview size
			width: 320,
			height: 240,
			
			// device capture size
			dest_width: 640,
			dest_height: 480,
			
			// final cropped size
			crop_width: 640,
			crop_height: 480,
			
			// format and quality
			image_format: 'jpeg',
			jpeg_quality: 90,
			
			// flip horizontal (mirror mode)
			flip_horiz: true
		});
        if(scope.flashFallbackUrl !== 'undefined') {
            Webcam.setSWFLocation(scope.flashFallbackUrl);
        }
       
        //Webcam.attach('#ng-camera-feed');
        /**
         * Register WebcamJS events
         */
       

        /**
         * Preload the shutter sound
         */
        if(scope.shutterUrl !== undefined) {
            scope.shutter = new Audio();
            scope.shutter.autoplay = false;
            if(navigator.userAgent.match(/Firefox/)) {
                scope.shutter.src = scope.shutterUrl.split('.')[0] + '.ogg';
            } else {
                scope.shutter.src = scope.shutterUrl;
            }
        }

        /**
         * Set countdown
         */
        if(scope.countdown !== undefined) {
            scope.countdownTime = parseInt(scope.countdown) * 1000;
            scope.countdownText = parseInt(scope.countdown);
        }
        scope.countdownStart = function() {
            scope.activeCountdown = true;
            scope.countdownPromise = $q.defer();
            scope.countdownTick = setInterval(function() {
                return scope.$apply(function() {
                    var nextTick;
                    nextTick = parseInt(scope.countdownText) - 1;
                    if(nextTick === 0) {
                        scope.countdownText = scope.captureMessage != null ? scope.captureMessage : 'GO!';
                        clearInterval(scope.countdownTick);
                        scope.countdownPromise.resolve();
                    }else{
                        scope.countdownText = nextTick;
                    }
                });
            }, 1000);
        };

        /**
         * Get snapshot
         */
        scope.getSnapshot = function() {
            if(scope.countdown !== undefined) {
                scope.countdownStart();
                scope.countdownPromise.promise.then(function() {
                    $timeout(function() {
                        scope.activeCountdown = false;
                        scope.countdownText = parseInt(scope.countdown);
                    }, 2000);

                    if(scope.shutterUrl !== undefined) {
                        scope.shutter.play();
                    }

                    Webcam.snap(function(data_uri) {
                        scope.snapshot = data_uri;
                        scope.showCapturedPicture = true;
                        Webcam.reset();
                    });
                });
            } else {
                if(scope.shutterUrl !== undefined) {
                    scope.shutter.play();
                }

                Webcam.snap(function(data_uri) {
                    scope.snapshot = data_uri;
                    scope.showCapturedPicture = true;
                    Webcam.reset();
                });
            }
        };
        
        scope.startCamera = function() {
        	scope.showCapturedPicture = false;
        	scope.cameraStarted = true;
        	Webcam.attach('#ng-camera-feed');
        	 Webcam.on('load', function() {
                 console.info('library loaded');
                 scope.$apply(function() {
                     scope.libraryLoaded = true;
                 });
             });
             Webcam.on('live', function() {
                 console.info('camera live');
                 scope.$apply(function() {
                     scope.cameraLive = true;
                 });
             });
             Webcam.on('error', function(error) {
                 console.error('WebcameJS directive ERROR: ', error);
             });
        };

        scope.$on('$destroy', function() {
            Webcam.reset();
        });
    
    }
    
    
});