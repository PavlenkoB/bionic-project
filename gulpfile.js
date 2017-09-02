'use strict';

var gulp = require('gulp');
var less = require('gulp-less');
var minify = require('gulp-minify-css');

gulp.task('less', function () {
    return gulp.src('./src/main/webapp/WEB-INF/web-resources/less/*.less')
        .pipe(less({
            paths: [
                '../src/main/webapp/WEB-INF/web-resources/css/'
            ]
        }))
        .pipe(minify({processImport: false}))
        .pipe(gulp.dest('./src/main/webapp/WEB-INF/web-resources/css/'));
});

gulp.task('build', ['less']);
gulp.task('default', ['less']);
//todo use Gulp