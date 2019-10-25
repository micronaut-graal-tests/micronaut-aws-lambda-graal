FROM python:alpine
RUN apk update && \
    apk upgrade && \
    apk add bash && \
    apk add --no-cache --virtual build-deps build-base gcc && \
    pip install aws-sam-cli && \
    apk del build-deps
EXPOSE 3000
ENTRYPOINT ["./sam_local.sh"]