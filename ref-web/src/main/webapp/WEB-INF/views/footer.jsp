<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
    <!-- footer -->
    <div class="app-footer wrapper b-t bg-light">
        <span class="pull-right">1.0.0 <a href="#app" class="m-l-sm text-muted"><i class="fa fa-long-arrow-up"></i></a></span>
        @2017 <a href="<%=request.getContextPath()%>/home" title="阅读论坛">阅读论坛</a>
    </div>
    <!-- / footer -->
</div>
<!-- jQuery -->
<script type="application/javascript" src="<%=request.getContextPath()%>/media/js/jquery.min.js"></script>
<script type="application/javascript" src="<%=request.getContextPath()%>/media/js/bootstrap.js"></script>
<script type="application/javascript" src="<%=request.getContextPath()%>/media/js/login.js"></script>
<script type="application/javascript" src="<%=request.getContextPath()%>/media/js/jquery.js"></script>
<script type="text/javascript">
    +function ($) {
        $(function(){
            // class
            $(document).on('click', '[data-toggle^="class"]', function(e){
                e && e.preventDefault();
                console.log('abc');
                var $this = $(e.target), $class , $target, $tmp, $classes, $targets;
                !$this.data('toggle') && ($this = $this.closest('[data-toggle^="class"]'));
                $class = $this.data()['toggle'];
                $target = $this.data('target') || $this.attr('href');
                $class && ($tmp = $class.split(':')[1]) && ($classes = $tmp.split(','));
                $target && ($targets = $target.split(','));
                $classes && $classes.length && $.each($targets, function( index, value ) {
                    if ( $classes[index].indexOf( '*' ) !== -1 ) {
                        var patt = new RegExp( '\\s' +
                                $classes[index].
                                replace( /\*/g, '[A-Za-z0-9-_]+' ).
                                split( ' ' ).
                                join( '\\s|\\s' ) +
                                '\\s', 'g' );
                        $($this).each( function ( i, it ) {
                            var cn = ' ' + it.className + ' ';
                            while ( patt.test( cn ) ) {
                                cn = cn.replace( patt, ' ' );
                            }
                            it.className = $.trim( cn );
                        });
                    }
                    ($targets[index] !='#') && $($targets[index]).toggleClass($classes[index]) || $this.toggleClass($classes[index]);
                });
                $this.toggleClass('active');
            });

            // collapse nav
            $(document).on('click', 'nav a', function (e) {
                var $this = $(e.target), $active;
                $this.is('a') || ($this = $this.closest('a'));

                $active = $this.parent().siblings( ".active" );
                $active && $active.toggleClass('active').find('> ul:visible').slideUp(200);

                ($this.parent().hasClass('active') && $this.next().slideUp(200)) || $this.next().slideDown(200);
                $this.parent().toggleClass('active');

                $this.next().is('ul') && e.preventDefault();

                setTimeout(function(){ $(document).trigger('updateNav'); }, 300);
            });
        });
    }(jQuery);
</script>