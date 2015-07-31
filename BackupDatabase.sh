#!/bin/bash

sudo -u postgres pg_dump -c SimpleBlog > CreateDatabase.sql
