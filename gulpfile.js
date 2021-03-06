'use strict';

var gulp = require('gulp'),
    less = require('gulp-less'),
    minify = require('gulp-minify-css'),
    livereload = require('gulp-livereload'),
    cleanCSS = require('gulp-clean-css'),
    sourcemaps = require('gulp-sourcemaps');

gulp.task('less', function () {
    return gulp.src('./src/main/webapp/WEB-INF/web-resources/less/style.less')
        .pipe(less({
            paths: [
                '../src/main/webapp/WEB-INF/web-resources/css/'
            ]
        }))
        .pipe(cleanCSS({
            format: 'beautify'
        }))
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