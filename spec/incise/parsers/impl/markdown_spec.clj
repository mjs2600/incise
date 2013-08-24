(ns incise.parsers.impl.markdown-spec
  (:require [speclj.core :refer :all]
            [clojure.java.io :refer [file resource]]
            [incise.core] ; Ensure that layouts have been loaded
            (incise.parsers [core :as pc]
                            [html :refer [html-parser]])
            [incise.parsers.impl.markdown :refer :all]
            [markdown.core :as md])
  (:import [java.io File]))

(describe "parsing"
  (with markdown-file (file (resource "spec/another-forgotten-binding-pry.md")))
  (with parser (html-parser md/md-to-html-string))
  (it "does something"
    (should-not-throw (@parser @markdown-file))))

(run-specs)