'use strict';

var gulp = require('gulp'),
    less = require('gulp-less'),
    minify = require('gulp-minify-css'),
    livereload = require('gulp-livereload');

gulp.task('less', function () {
    return gulp.src('./src/main/webapp/WEB-INF/web-resources/less/*.less')
        .pipe(less({
            paths: [
                '../src/main/webapp/WEB-INF/web-resources/css/'
            ]
        }))
        .pipe(minify({processImport: false}))
        .pipe(gulp.dest('./src/main/webapp/WEB-INF/web-resources/css/'))
        .pipe(livereload());
});
gulp.task('watch', function () {
    livereload.listen();
    gulp.watch(
        './src/main/webapp/WEB-INF/web-resources/less/*.less',
        ['less']
    );
});
gulp.task('build', ['less']);
gulp.task('default', ['less', 'watch']);
//todo use Gulp