FROM node:18.12.1-alpine

RUN mkdir -p /usr/src/app

WORKDIR /usr/src/app

COPY . .

RUN npm install
RUN mkdir /.npm && \
    chown -R 1000:0 /.npm && \
    chmod -R g=u /.npm

EXPOSE 4000

CMD ["npm", "run", "start"]